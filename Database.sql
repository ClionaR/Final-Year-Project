CREATE TABLE Animals (
    ImpoundID int Primary Key,
    ImpoundDate Date,
    Name varchar(30),
	Gender varchar(10),
	Breed varchar(10),
	Species varchar(20),
	Age varchar(10),
	Colour varchar(20),
	ImpoundCode varchar(20),
	Status varchar(20),
	LocationFound varchar(50),
	Description varchar(50),
	Weight varchar(30),
	Neutered varchar(4),
	DateNeutered Date
);

INSERT INTO Animals
VALUES (1, 2017-11-21, "Milly", "Female", "Labrador", "Dog", "Adult", "Black", "Stray", "Healthy", "Dun Laoghaire", "Found in an abandoned house", "10kg", "Yes", 2017-11-21);

INSERT INTO Animals
VALUES (2, 2017-11-23, "Scott", "Male", "Great Dane", "Dog", "Adult", "White", "Stray", "Kennel Cough", "Dun Laoghaire", "Found in an abandoned house", "30kg", "Yes", 2017-11-21);