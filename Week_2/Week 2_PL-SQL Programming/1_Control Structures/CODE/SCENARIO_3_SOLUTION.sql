DECLARE
    CURSOR myCursor IS
        SELECT l.LoanID, c.Name, l.EndDate
        FROM Loans l JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate <= SYSDATE + 30;
    
    entry myCursor%ROWTYPE;
BEGIN
    FOR entry IN myCursor LOOP
        DBMS_OUTPUT.PUT_LINE(
            'REMINDER : LOAN ID ' || entry.LoanID ||
            ' FOR CUSTOMER ' || entry.Name ||
            ' IS DUE ON ' || TO_CHAR(entry.EndDate, 'DD-MM-YYYY')
        );
    END LOOP;
    COMMIT;
END;