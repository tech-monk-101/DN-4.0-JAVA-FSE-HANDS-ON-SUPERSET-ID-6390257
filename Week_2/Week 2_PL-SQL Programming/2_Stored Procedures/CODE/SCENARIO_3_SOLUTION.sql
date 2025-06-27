--STORED PROCEDURE
CREATE OR REPLACE PROCEDURE TransferFunds (
    fromAccount IN Accounts.AccountID%TYPE,
    toAccount IN Accounts.AccountID%TYPE,
    amt IN NUMBER
) AS
    balanceAmount Accounts.Balance%TYPE;
BEGIN
    --CHECKING IF BALANCE IS SUFFICIENT
    SELECT Balance INTO balanceAmount
    FROM Accounts
    WHERE AccountID = fromAccount
    FOR UPDATE;

    IF balanceAmount < amt THEN
        RAISE_APPLICATION_ERROR(-20001, 'INSUFFICIENT BALANCE IN SOURCE ACCOUNT');
    END IF;

    --DEDUCT FROM SOURCE
    UPDATE Accounts
    SET Balance = Balance - amt, LastModified = SYSDATE
    WHERE AccountID = fromAccount;

    --ADD TO DESTINATION
    UPDATE Accounts
    SET Balance = Balance + amt, LastModified = SYSDATE
    WHERE AccountID = toAccount;

    COMMIT;
END;
/

--TESTING (MAKES CHANGES)
DECLARE
    CURSOR myCursor IS
        SELECT AccountID, Balance
            FROM Accounts
            WHERE AccountID IN (1, 2);
    
    entry myCursor%ROWTYPE;

BEGIN
    DBMS_OUTPUT.PUT_LINE('BALANCE BEFORE TRANSFER:');
    FOR entry IN myCursor LOOP
        DBMS_OUTPUT.PUT_LINE('ACCOUNT : ' || entry.AccountID || ':' || entry.Balance || '/-');
    END LOOP;

    TransferFunds(1, 2, 1000);

    DBMS_OUTPUT.PUT_LINE('BALANCE AFTER TRANSFER:');
    FOR entry IN myCursor LOOP
        DBMS_OUTPUT.PUT_LINE('ACCOUNT : ' || entry.AccountID || ' | BALANCE : ' || entry.Balance || '/-');
    END LOOP;
END;
