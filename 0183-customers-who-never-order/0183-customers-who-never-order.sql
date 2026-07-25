SELECT name AS Customers
FROM Customers AS C
LEFT JOIN Orders O 
ON C.id = O.customerId
WHERE customerId IS NULL