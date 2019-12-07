import ModelError from './ModuleError';
import sqlite3 from 'sqlite3';

class Model {

    constructor () {
        this.db  = new sqlite3.Database('./1.db', sqlite3.OPEN_READWRITE | sqlite3.OPEN_CREATE);
    }

    findAll(sql, params) {
        return new Promise((resolve, reject) => {
            this.db.all(sql, params, (error, rows) => {
                if (error) {
                    reject(new ModelError(20, 'Internal Server Error'));
                }
                else if (rows === null || rows.length === 0) {
                    reject(new ModelError(21, 'Entity Not Found'));
                }
                else {
                    resolve(rows);
                }
            });
        });
    }

    findOne(sql, params) {
        return new Promise((resolve, reject) => {
            this.db.run(sql, params, (error, rows) => {
                if (error) {
                    reject(new ModelError(11, 'Invalid Arguments'));
                }
                else if (rows === null || rows.length === 0) {
                    reject(new ModelError(21, 'Entity Not Found'));
                }
                else {
                    const row = rows[0];
                    resolve(row);
                }
            });
        });
    }

    run(sql) {
        console.log(sql);
        return new Promise((resolve, reject) => {
            this.db.run(sql, function (error) {
                if (!error){
                    reject(error);
                }
                resolve({msg: "Success!"});
            });
        });
    }
}

export default Model;