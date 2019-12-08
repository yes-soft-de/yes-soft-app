const sqlite3 = require('sqlite3').verbose();

const db = new sqlite3.Database('./1.db');

const init = () => {
    db.run(`
        CREATE TABLE IF NOT EXISTS employee (
            id  INTEGER PRIMARY KEY  AUTOINCREMENT,
            name TEXT ,
            age INTEGER ,
            position TEXT ,
            link TEXT
        );
    `);

    db.run(`
            CREATE TABLE IF NOT EXISTS projects (
            id  INTEGER PRIMARY KEY  AUTOINCREMENT,
            employee_id INTEGER,
            start_date TEXT,
            end_date TEXT,
            title TEXT,
            link TEXT
        );
    `);

    db.run(`
        CREATE TABLE IF NOT EXISTS blogs (
            id  INTEGER PRIMARY KEY  AUTOINCREMENT ,
            employee_id INTEGER ,
            start_date TEXT ,
            link TEXT ,
            title TEXT
        );
    `);
    db.run(`
        CREATE TABLE IF NOT EXISTS skills (
            id  INTEGER PRIMARY KEY  AUTOINCREMENT,
            employee_id INTEGER ,
            skill TEXT
        );
    `);
};

module.exports = {
    db: db,
    init: init
};
