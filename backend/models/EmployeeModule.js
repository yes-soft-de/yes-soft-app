import EmployeeInfoEntity from '../entity/EmployeeInfoEntity';
import Model from "./Module";

class EmployeeModule {

    constructor() {
        this.model = new Model();
    }

    findAll() {
        const sql = `SELECT * FROM employee`;
        return this.model.findAll(sql)
            .then((resultList) => {
                const employeesInfo = [];

                for (const result of resultList) {
                    employeesInfo.push(new EmployeeInfoEntity(result.id, result.name, result.age, result.position, result.quote, result.link));
                }

                return employeesInfo;
            });
    }

    findInfoById(id) {
        const sql = `SELECT * FROM employee WHERE id = $id`;
        const params = {
            $id: id
        };

        return this.model.findOne(sql, params)
            .then((result) => {
                return new EmployeeInfoEntity(result.id, result.name, result.age, result.position, result.quote, result.link);
            });
    }

    createInfo(employee) {
        const sql = `INSERT INTO employee (name, age , position, link) VALUES
            ("${employee.name}", ${employee.age}, "${employee.position}", "${employee.link}")`;
        const params = {
            $name: employee.name,
            $age: employee.age,
            $position: employee.age,
            $link: employee.link
        };

        return this.model.run(sql, params)
            .then((id) => {
                return this.model.findOne(id);
            });
    }

    deleteInfo(id) {
        const sql = `DELETE FROM employee WHERE id = $id`;

        const params = {
            $id: id
        };

        return this.model.run(sql, params);
    }
}

export default EmployeeModule;
