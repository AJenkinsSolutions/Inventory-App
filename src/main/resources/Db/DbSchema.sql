-- Creating the categories table
USE techinventorydb;

CREATE TABLE categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL,
    description TEXT,
    parent_category_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    last_updated TIMESTAMP,
    FOREIGN KEY (parent_category_id) REFERENCES categories(category_id)
);

-- Creating the inventory_items table
CREATE TABLE inventory_items (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(255) NOT NULL,
    category_id INT,
    quantity INT,
    location VARCHAR(255),
    description TEXT,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    last_updated TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES categories(category_id)
);

-- Creating the users table
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    is_active BOOLEAN DEFAULT TRUE,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    last_updated TIMESTAMP,
    password_reset_token VARCHAR(255),
    token_expiration TIMESTAMP
);

-- Creating the roles table
CREATE TABLE roles (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL UNIQUE,
    parent_role_id INT,                   -- For role hierarchies
	description TEXT,						-- Changed to TEXT for longer descriptions
    is_active BOOLEAN DEFAULT TRUE,      	-- New field to activate/deactivate roles
    level INT,  							-- field for role priority or level
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    last_updated TIMESTAMP,
     FOREIGN KEY (parent_role_id) REFERENCES roles(role_id)
);

-- Creating the user_roles join table
CREATE TABLE user_roles (
    user_id INT,
    role_id INT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (role_id) REFERENCES roles(role_id)
);

-- Creating the transaction_histories table
CREATE TABLE transaction_histories (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    item_id INT,
    user_id INT,
    action_type ENUM('ADD', 'REMOVE', 'UPDATE', 'CHECKOUT', 'CHECKIN',  'RETURN', 'REPAIR', 'AUDIT') NOT NULL,
	previous_quantity INT,
    new_quantity INT,
    from_location VARCHAR(255),
    to_location VARCHAR(255),
    status VARCHAR(255),
    notes TEXT,
    transaction_value DECIMAL(10, 2),
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    last_updated TIMESTAMP,
    FOREIGN KEY (item_id) REFERENCES inventory_items(item_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
