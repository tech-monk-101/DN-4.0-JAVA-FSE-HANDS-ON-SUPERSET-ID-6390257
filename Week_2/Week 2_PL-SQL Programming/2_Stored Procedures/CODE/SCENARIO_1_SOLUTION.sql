--STORED PROCEDURE
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01), LastModified = SYSDATE
    WHERE AccountType = 'Savings';
    COMMIT;
END;
/

--TESTING (MAKES CHANGES)
DECLARE
    CURSOR myCursor IS 
        SELECT AccountID, Balance, LastModified
        FROM Accounts
        WHERE AccountType = 'Savings';
    
    entry myCursor%ROWTYPE;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Balances before interest calculation: ');
    FOR entry IN myCursor LOOP
        DBMS_OUTPUT.PUT_LINE(
            'ACCOUNT ' || entry.AccountID ||
            ': BALANCE = ' || entry.Balance ||
            ', LAST MODIFIED = ' || TO_CHAR(entry.LastModified, 'DD-MM-YYYY HH24:MI:SS')
        );
    END LOOP;
    ProcessMonthlyInterest;
    DBMS_OUTPUT.PUT_LINE('Balances after interest calculation (before rollback):');
    FOR entry IN myCursor LOOP
        DBMS_OUTPUT.PUT_LINE(
            'ACCOUNT ' || entry.AccountID ||
            ': BALANCE = ' || entry.Balance ||
            ', LAST MODIFIED = ' || TO_CHAR(entry.LastModified, 'DD-MM-YYYY HH24:MI:SS')
        );
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('TEST COMPLETED');
END;
/
