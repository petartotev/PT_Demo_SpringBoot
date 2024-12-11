package com.petartotev.studentboot.repository;

import com.petartotev.studentboot.model.Car;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/* PT: This was the original CarRepository using JDBC before Resilience4j Retry mechanism was implemented */
@Repository
public class CarRepositoryOld {

    private final JdbcTemplate jdbcTemplate;

    public CarRepositoryOld(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
        if (car.getId() == null) {
            // Insert new car
            String sql = "INSERT INTO car (brand, model, color, year) VALUES (?, ?, ?, ?) RETURNING id";
            Long id = jdbcTemplate.queryForObject(sql, Long.class, car.getBrand(), car.getModel(), car.getColor().name(), car.getYear());
            car.setId(id);
        } else {
            // Update existing car
            String sql = "UPDATE car SET brand = ?, model = ?, color = ?, year = ? WHERE id = ?";
            jdbcTemplate.update(sql, car.getBrand(), car.getModel(), car.getColor().name(), car.getYear(), car.getId());
        }
        return car;
    }

    public Optional<Car> findById(Long id) {
        String sql = "SELECT * FROM car WHERE id = ?";
        List<Car> cars = jdbcTemplate.query(sql, carRowMapper, id);
        return cars.stream().findFirst();
    }

    public List<Car> findAll() {
        String sql = "SELECT * FROM car";
        return jdbcTemplate.query(sql, carRowMapper);
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM car WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}