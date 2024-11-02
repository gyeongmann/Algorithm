SELECT FLAVOR
FROM (
    SELECT 
    FLAVOR, TOTAL_ORDER FROM JULY
    UNION ALL
    SELECT FLAVOR, TOTAL_ORDER FROM FIRST_HALF
) A
GROUP BY A.FLAVOR
ORDER BY SUM(TOTAL_ORDER) DESC
LIMIT 3