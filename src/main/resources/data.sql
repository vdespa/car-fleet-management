DROP TABLE IF EXISTS cars;
DROP TABLE IF EXISTS repairs;

CREATE TABLE cars (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  manufacturer VARCHAR(250) NOT NULL,
  model VARCHAR(250) NOT NULL,
  build YEAR DEFAULT NULL
);

INSERT INTO cars (manufacturer, model, build) VALUES
  ('Ford', 'Model T', 1927),
  ('Tesla', 'Model 3', 2017),
  ('Tesla', 'Cybertruck', 2019);


CREATE TABLE repairs (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  car_Id INT NOT NULL,
  repair_date DATE NOT NULL,
  description VARCHAR(250) DEFAULT NULL
);

INSERT INTO repairs (car_Id, repair_date, description) VALUES
  (1, '2018-05-17', 'Fixed rear suspension'),
  (3, '2019-05-15', 'Catalytic Converter Replacement'),
  (1, '2019-05-15', 'Spark Plug Replacement'),
  (2, '2019-08-11', 'Oil change'),
  (3, '2019-01-15', 'Spark Plug Replacement'),
  (2, '2020-01-18', 'Ignition Coil and Spark Plug Replacement'),
  (1, '2019-11-05', 'Ignition Coil Replacement'),
  (1, '2020-01-25', 'Fixed rear suspension'),
  (2, '2020-02-21', 'Fuel Cap Replacements'),
  (1, '2019-12-01', 'Thermostat Replacement'),
  (2, '2020-02-12', 'Changed light bulb');