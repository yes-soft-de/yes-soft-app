import * as express from "express";
import { Request, Response } from "express";
import ProjectManager from "../manager/project.manager";

export default class ProjectController {
    public path = "/project";
    public router = express.Router();

    private projectManager: ProjectManager;

    constructor() {
        this.router.get(`${this.path}`, (req, res) => { this.getAll(res); });
        this.router.get(`${this.path}/:employee_id`, (req, res) => {
            this.getEmployeeProjects(req, res);
        });
        this.router.delete(`${this.path}/:id`, (req, res) => { this.deleteProject(req, res); });
        this.router.post(`${this.path}`, (req, res) => { this.addProject(req, res); });
        this.projectManager = new ProjectManager();
    }

    public getAll(res: Response) {
        this.projectManager.getAll(res);
    }

    public getEmployeeProjects(req: Request, res: Response) {
        this.projectManager.getEmployeeProjects(req, res);
    }

    public addProject(req: Request, res: Response) {
        this.projectManager.addProject(req, res);
    }

    public deleteProject(req: Request, res: Response) {
        this.projectManager.deleteProject(req, res);
    }
}
