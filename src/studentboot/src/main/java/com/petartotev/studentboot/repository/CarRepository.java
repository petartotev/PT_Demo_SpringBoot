package com.petartotev.studentboot.repository;

import com.petartotev.studentboot.model.Car;
import io.github.resilience4j.retry.Retry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Repository
public class CarRepository {
    private final JdbcTemplate jdbcTemplate;
    private final Retry retry;

    public CarRepository(JdbcTemplate jdbcTemplate, Retry retry) {
        this.jdbcTemplate = jdbcTemplate;
        this.retry = retry;
    }

    private final RowMapper<Car> carRowMapper = (rs, rowNum) -> {
        Car car = new Car();
        car.setId(rs.getLong("id"));
        car.setBrand(rs.getString("brand"));
        car.setModel(rs.getString("model"));
        car.setColor(Car.Color.valueOf(rs.getString("color").toUpperCase()));
        car.setYear(rs.getInt("year"));
        return car;
    };

    public Car save(Car car) {
        Supplier<Car> saveSupplier = Retry.decorateSupplier(retry, () -> {
            if (car.getId() == null) {
                String sql = "INSERT INTO car (brand, model, color, year) VALUES (?, ?, ?, ?) RETURNING id";
                Long id = jdbcTemplate.queryForObject(sql, Long.class, car.getBrand(), car.getModel(), car.getColor().name(), car.getYear());
                car.setId(id);
            } else {
                String sql = "UPDATE car SET brand = ?, model = ?, color = ?, year = ? WHERE id = ?";
                jdbcTemplate.update(sql, car.getBrand(), car.getModel(), car.getColor().name(), car.getYear(), car.getId());
            }
            return car;
        });

        return saveSupplier.get();
    }

    public Optional<Car> findById(Long id) {
        Supplier<Optional<Car>> findSupplier = Retry.decorateSupplier(retry, () -> {
            throw new RuntimeException("Simulated database failure"); /* in order to test Resilience4j retry */
//            String sql = "SELECT * FROM car WHERE id = ?";
//            List<Car> cars = jdbcTemplate.query(sql, carRowMapper, id);
//            return cars.stream().findFirst();
        });

        return findSupplier.get();
    }

    public List<Car> findAll() {
        Supplier<List<Car>> findAllSupplier = Retry.decorateSupplier(retry, () -> {
            String sql = "SELECT * FROM car";
            return jdbcTemplate.query(sql, carRowMapper);
        });

        return findAllSupplier.get();
    }

    public void deleteById(Long id) {
        Runnable deleteRunnable = Retry.decorateRunnable(retry, () -> {
            String sql = "DELETE FROM car WHERE id = ?";
            jdbcTemplate.update(sql, id);
        });

        deleteRunnable.run();
    }
}