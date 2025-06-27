-- STORED PROCEDURE
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept IN Employees.Department%TYPE,
    bonus_percent IN NUMBER 
) AS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * (bonus_percent / 100))
    WHERE Department = dept;
    COMMIT;
END;
/
-- TESTING (MAKES CHANGES)
BEGIN
    DBMS_OUTPUT.PUT_LINE('PREVIOUS SALARIES: ');
    FOR entry IN (
        SELECT EmployeeID, Name, Salary
        FROM Employees
        WHERE Department = 'IT'
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'EMP_ID: ' || entry.EmployeeID ||
            ', NAME: ' || entry.Name ||
            ', UPDATED SALARY: ' || entry.Salary
        );
    END LOOP;
    UpdateEmployeeBonus('IT', 10);
    DBMS_OUTPUT.PUT_LINE('BONUS APPLIED TO IT DEPARTMENT');
        
    DBMS_OUTPUT.PUT_LINE('UPDATED SALARIES: ');

    FOR entry IN (
        SELECT EmployeeID, Name, Salary
        FROM Employees
        WHERE Department = 'IT'
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'EMP_ID: ' || entry.EmployeeID ||
            ', NAME: ' || entry.Name ||
            ', UPDATED SALARY: ' || entry.Salary
        );
    END LOOP;
END;
/