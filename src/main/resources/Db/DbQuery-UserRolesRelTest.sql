SELECT u.username, r.role_name FROM users u
JOIN user_roles ur ON u.user_id = ur.user_id
JOIN roles r ON ur.role_id = r.role_id;

-- Purpose
-- This query is designed to test the relationships between the users, roles, and user_roles tables in the database. It verifies that roles are correctly assigned to users and that the joins between these tables function as expected.\

-- Tables Involved
-- users: Contains user information.
-- roles: Defines the various roles that can be assigned to users.
-- user_roles: A join table mapping users to their roles.
-- Test Data Insertion


-- Expected Outcome
-- The query joins the users, user_roles, and roles tables and retrieves the username along with their respective roles.
--  The expected outcome is a list of users and their assigned roles, confirming that the relationships and data insertion are correctly implemented.


-- Usage
-- Use this query during the initial setup of the database and after any significant changes to the structure of the involved tables.
-- It's particularly useful for developers and database administrators to verify the integrity of user-role relationships.
-- Notes
-- Replace the test data with actual data in a production environment.
-- Ensure the security of password hashes and sensitive user information.

-- INSERT INTO users (username, password, email, is_active) VALUES 
-- ('user1', 'passwordHash1', 'user1@example.com', TRUE),
-- ('user2', 'passwordHash2', 'user2@example.com', TRUE),
-- ('user3', 'passwordHash3', 'user3@example.com', TRUE);


-- INSERT INTO roles (role_name) VALUES 
-- ('ADMIN'),
-- ('USER'),
-- ('VIEWER');


-- INSERT INTO user_roles (user_id, role_id) VALUES 
-- (1, 1),  -- Assigning 'ADMIN' role to 'user1'
-- (1, 2),  -- Also assigning 'USER' role to 'user1'
-- (2, 2),  -- Assigning 'USER' role to 'user2'
-- (3, 3);  -- Assigning 'VIEWER' role to 'user3'

-- SELECT u.username, r.role_name FROM users u
-- JOIN user_roles ur ON u.user_id = ur.user_id
-- JOIN roles r ON ur.role_id = r.role_id;
