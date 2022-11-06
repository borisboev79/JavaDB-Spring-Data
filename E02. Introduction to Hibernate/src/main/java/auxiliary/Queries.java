package auxiliary;

public enum Queries {
    ;
    public static final String GET_ALL_TOWNS = "SELECT t FROM TOWNS t";
    public static final String GET_NAME_LENGTH_MORE_THAN_5 = "SELECT t FROM Town t WHERE LENGTH(t.name) <= 5";
    public static final String GET_SALARY_OVER_50000 = "SELECT e.firstName FROM Employee e WHERE e.salary > 50000";
    public static final String GET_ADDRESSES_BY_EMPLOYEES = "SELECT a FROM Address a ORDER BY a.employees.size DESC";
    public static final String UPDATE_ADDRESS = "UPDATE Employee e SET e.address = ";
    public static final String GET_DEPARTMENTS = "SELECT d.id FROM Department d WHERE d.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services')";
    public static final String GET_EMPLOYEES_BY_ID = "SELECT e from Employee e WHERE e.id = ";
    public static final String GET_PROJECTS_BY_START_DATE = "SELECT p FROM Project p ORDER BY p.startDate DESC";
    public static final String GET_NAMES_BY_PATTERN = "SELECT e FROM Employee e WHERE e.firstName LIKE ";
    public static final String GET_DEPARTMENTS_MAX_SALARIES = "SELECT e.department.name, MAX(e.salary) FROM Employee e GROUP BY e.department.name HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000";
    public static final String GET_TOWN_NAME = "SELECT t FROM Town t WHERE t.name = ";
    public static final String GET_ADDRESSES_BY_TOWN_NAME = "SELECT a FROM Address a WHERE a.town.name = ";
}
