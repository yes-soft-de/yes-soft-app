import { Request, Response } from "express";
import Skill from "../entity/skill.entity";

export default class SkillRepository {

    public async getEmployeeSkills(employeeId: number, res: Response) {
        Skill.findAll({
            "where": {
                "employeeId": employeeId
            }
        })
            .then((result) => {
                res.send(result);
            }).catch((err) => { res.send(err); });
    }

    public async insertSkillToEmployee(employeeId: number, skills: string[], res: Response) {
        const objects = [];
        for (const s of skills) {
            objects.push({
                "employeeId": employeeId,
                "skill": s
            });
        }
        Skill.bulkCreate(objects)
            .then((result) => {
                res.send(result);
            }).catch((err) => { res.send(err); });
    }

    public async clearSkills(employeeId: number, res: Response) {
        Skill.destroy({
            "where": {
                "employeeId": employeeId
            }
        }).then((result) => {
            res.send(result);
        }).catch((err) => { res.send(err); });
    }
}
