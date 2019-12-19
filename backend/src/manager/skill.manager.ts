import { Request, Response } from "express";
import SkillRepository from "../repository/skill.repo";

export default class SkillManager {
    private skillRepo: SkillRepository;

    constructor() {
        this.skillRepo = new SkillRepository();
    }

    public async insertSkillToEmployee(req: Request, res: Response) {
        this.skillRepo.insertSkillToEmployee(+req.params.employee_id, req.body, res);
    }

    public async getEmployeeSkills(req: Request, res: Response) {
        this.skillRepo.getEmployeeSkills(+req.params.employee_id, res);
    }

    public async clearSkills(req: Request, res: Response) {
        this.skillRepo.clearSkills(+req.params.employee_id, res);
    }
}
