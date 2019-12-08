import Model from './Module';
import SkillsEntity from '../entity/SkillsEntity';

class SkillModule {

    constructor() {
        this.model = new Model();
    }

    findAll() {
        const sql = `SELECT * FROM skills`;

        return this.model.findAll(sql)
            .then((result) => {
                const skillsList = [];

                for (const row of result) {
                    skillsList.push(new SkillsEntity(row.id, row.skill, row.employee_id));
                }

                return skillsList;
            }). catch(err => {
                console.log(err);
            });
    }

    findSkillById(id) {
        const sql = `SELECT * FROM skills WHERE id = $id`;
        const params = {
            $id: id
        };

        return this.model.findAll(sql, params)
            .then((result) => {
                return new SkillsEntity(result.id, result.skill, result.employee_id);
            });
    }

    findSkillByEmployeeId(id) {
        const sql = `SELECT * FROM skills WHERE employee_id = $id`;
        const params = {
            $id: id
        };


        return this.model.findAll(sql, params)
            .then((result) => {
                const skillList = [];
                for (const row of result) {
                    skillList.push(new SkillsEntity(row.id, row.skill, row.employee_id));
                }
                return skillList;
            });
    }

    createSkill(skill) {
        const sql = `INSERT INTO skills (employee_id, skill) 
            VALUES (${skill.employee_id}, "${skill.skill}");`;

        return this.model.run(sql)
            .then((msg) => {
                return msg;
            }).catch(err => {
                console.log(err);
            });
    }

    delete(id) {
        const sql = `DELETE FROM skills WHERE id = $id`;

        const params = {
            $id: id
        };

        return this.model.run(sql, params);
    }
}

export default SkillModule;
