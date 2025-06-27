-- Adding IsVIP Flag To Customers Table
ALTER TABLE Customers ADD (
    IsVIP CHAR(1) DEFAULT 'N'
);

DECLARE
    CURSOR myCursor IS
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000;
    entry myCursor%ROWTYPE;

BEGIN
    FOR entry IN myCursor LOOP
        UPDATE Customers
        SET IsVIP = 'Y', LastModified = SYSDATE
        WHERE CustomerID = entry.CustomerID;
        DBMS_OUTPUT.PUT_LINE('CUSTOMER ID ' || entry.CustomerID || ' UPGRADED TO VIP STATUS');
    END LOOP;
    COMMIT;
END;
