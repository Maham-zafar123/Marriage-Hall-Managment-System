-- Create Customer table
CREATE TABLE CUSTOMER_T (
    CustomerID NUMBER PRIMARY KEY auto_increment,
    customerName VARCHAR2(50),
    customerContact VARCHAR2(20) UNIQUE,
    customerCity VARCHAR2(50),
    customerGender VARCHAR2(10),
    customerEmail VARCHAR2(100) UNIQUE,
    customerPassword VARCHAR2(100),
    CONSTRAINT chk_password CHECK (LENGTH(customerPassword) >= 8 AND REGEXP_LIKE(customerPassword, '\d')),
    CONSTRAINT chk_email CHECK (REGEXP_LIKE(customerEmail, '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$')),
    CONSTRAINT chk_gender CHECK (customerGender IN ('Male', 'Female', 'Other'))
);

-- Create Manager table
CREATE TABLE Manager (
    ManagerID NUMBER PRIMARY KEY,
    managerContact VARCHAR2(20),
    managerEmail VARCHAR2(100),
    password VARCHAR2(100),
    CONSTRAINT chk_manager_password CHECK (LENGTH(password) >= 8 AND REGEXP_LIKE(password, '\d')),
    CONSTRAINT chk_manager_email CHECK (REGEXP_LIKE(managerEmail, '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'))
);


-- Insert values into Customer table
INSERT INTO Customer_T ( customerName, customerContact, customerCity, customerGender, customerEmail, customerPassword)
VALUES
    ('John Doe', '1234567890', 'New York', 'Male', 'john.do@eexample.com', 'Password1');

-- Insert values into Manager table
INSERT INTO Manager (ManagerID, managerContact, managerEmail, password)
VALUES
    (1, '555-1234', 'manager@example.com', 'ManagerP@ssw0rd1');
    
DROP TAble Customer_T;


SELECT customerEmail,customerPassword FROM Customer_T;


CREATE SEQUENCE id_seq;

CREATE TRIGGER student_bi
BEFORE INSERT ON Customer_T
FOR EACH ROW
BEGIN
  SELECT id_seq.nextval
  INTO :new.customerID
  FROM dual;
END;
