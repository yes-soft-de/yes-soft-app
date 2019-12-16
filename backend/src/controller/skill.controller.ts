import * as express from "express";
import { Request, Response } from "express";
import SkillManager from "../manager/skill.manager";

export default class SkillController {
    public path = "/skill";
    public router = express.Router();

    private skillManager: SkillManager;

    constructor() {
        this.router.get(`${this.path}/:employee_id`, (req, res) => { this.getEmployeeSkills(req, res); });
        this.router.post(`${this.path}/:employee_id`, (req, res) => { this.insertSkillToEmployee(req, res); });
        this.skillManager = new SkillManager();
    }

    public insertSkillToEmployee(req: Request, res: Response) {
        this.skillManager.insertSkillToEmployee(req, res);
    }

    public getEmployeeSkills(req: Request, res: Response) {
        this.skillManager.getEmployeeSkills(req, res);
    }

    public clearSkills(req: Request, res: Response) {
        this.skillManager.clearSkills(req, res);
    }
}
