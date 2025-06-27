DECLARE
    CURSOR myCursor IS 
        SELECT * FROM Customers;
    
    entry myCursor%ROWTYPE;
BEGIN
    FOR entry IN myCursor LOOP
        IF (MONTHS_BETWEEN(sysdate, entry.DOB) / 12) > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = entry.CustomerID;
            DBMS_OUTPUT.PUT_LINE('DISCOUNTED CUSTOMER ID :' || entry.CustomerID);
        END IF;
    END LOOP;
    COMMIT;
END;