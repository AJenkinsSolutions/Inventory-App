INSERT INTO users (username, password, email, is_active) VALUES 
('user1', 'passwordHash1', 'user1@example.com', TRUE),
('user2', 'passwordHash2', 'user2@example.com', TRUE),
('user3', 'passwordHash3', 'user3@example.com', TRUE);
INSERT INTO roles (role_name) VALUES 
('ADMIN'),
('USER'),
('VIEWER');
-- Assuming user_id and role_id start from 1
INSERT INTO user_roles (user_id, role_id) VALUES 
(1, 1),  -- Assigning 'ADMIN' role to 'user1'
(1, 2),  -- Also assigning 'USER' role to 'user1'
(2, 2),  -- Assigning 'USER' role to 'user2'
(3, 3);  -- Assigning 'VIEWER' role to 'user3'

-- This query should return a list of users along with their assigned roles, which will help you verify that the relationships between the tables are set up correctly.

-- Important Considerations
-- Ensure that the password hashes you use in the test data are not from actual users for security reasons.
-- After testing, consider clearing the test data, especially if you're working in a production environment.
-- This procedure assumes auto-increment is set up for user_id and role_id. Adjust the INSERT statements if your IDs are different.
-- Testing these relationships is crucial for ensuring that your user-role mapping is functioning as intended, which is fundamental for access control and permissions management in your application.