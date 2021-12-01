DROP TABLE IF EXISTS parkingSlot;
DROP TABLE IF EXISTS reservation;

CREATE TABLE parkingSlot (
  slotId INT PRIMARY KEY,
  isAvailable BOOLEAN
);

CREATE TABLE reservation (
  reservationId INT PRIMARY KEY,
  slotId INT NOT NULL,
  foreign key (slotId) references parkingSlot(slotId),
  registrationNumber VARCHAR(250) NOT NULL,
  parkingTime_Hours DOUBLE NOT NULL
);