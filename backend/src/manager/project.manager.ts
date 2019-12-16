import { Request, Response } from "express";
import ProjectRepository from "../repository/project.repo";

export default class ProjectManager {
    private projectRepo: ProjectRepository;

    constructor() {
        this.projectRepo = new ProjectRepository();
    }

    public getAll(res: Response) {
        this.projectRepo.getAll(res);
    }

    public getEmployeeProjects(req: Request, res: Response) {
        this.projectRepo.getEmployeeProjects(+req.params.employee_id, res);
    }

    public addProject(req: Request, res: Response) {
        this.projectRepo.addProject(req.body, res);
    }

    public deleteProject(req: Request, res: Response) {
        this.projectRepo.deleteProject(+req.params.id, res);
    }
}
