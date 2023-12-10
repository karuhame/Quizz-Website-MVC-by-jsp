USE CNW;

CREATE TABLE Test(
	ID_Test INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255)
);

CREATE TABLE Account (
  ID_Account INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255),
  password VARCHAR(255),
  role INT
);

-- Create Account Info table
CREATE TABLE Account_Info (
  ID_Info INT AUTO_INCREMENT PRIMARY KEY,
  Name VARCHAR(255),
  Gender VARCHAR(10),
  Address VARCHAR(255),
  ID_Account INT,
  Mark INT,
  FOREIGN KEY (ID_Account) REFERENCES Account(ID_Account)
);

-- Create Result table
CREATE TABLE Result (
  ID_Result INT AUTO_INCREMENT PRIMARY KEY,
  Marks INT,
  ID_Test INT,
  ID_Account INT,
  FOREIGN KEY (ID_Account) REFERENCES Account(ID_Account),
  FOREIGN KEY (ID_Test) REFERENCES Test(ID_Test)

);

-- Create Question table
CREATE TABLE Question (
  ID_Question INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  opt1 VARCHAR(255),
  opt2 VARCHAR(255),
  opt3 VARCHAR(255),
  opt4 VARCHAR(255),
  answer VARCHAR(255),
  ID_Test INT,
  FOREIGN KEY (ID_Test) REFERENCES Test(ID_Test)
);


INSERT INTO account (ID_Account, username, password, role)
VALUES 
  (1, 'user1', 'pass1', 0),
  (2, 'user2', 'pass2', 1),
  (3, 'user3', 'pass3', 1);
  
INSERT INTO test (ID_Test, Name)
VALUES 
  (1, 'LTM'),
  (2, 'Cong nghe Web');
  
INSERT INTO account_info (ID_Info, Name, MSSV, LSH, ID_Account)
VALUES 
  (1, 'John', '123456', '2021', 1),
  (2, 'Sarah', '789012', '2022', 2),
  (3, 'Michael', '345678', '2021', 3);
  
  
INSERT INTO question (ID_Question, name, opt1, opt2, opt3, opt4, answer, ID_Test)
VALUES 
  (1, 'Question 1', 'Option 1', 'Option 2', 'Option 3', 'Option 4', 2, 1),
  (2, 'Question 2', 'Option 1', 'Option 2', 'Option 3', 'Option 4', 3, 1),
  (3, 'Another Question', 'Option A', 'Option B', 'Option C', 'Option D', 4, 2);
  
INSERT INTO result (ID_Result, Mark, ID_Test, ID_Account)
VALUES 
  (1, 80, 1, 1),
  (2, 75, 1, 2),
  (3, 90, 2, 3);