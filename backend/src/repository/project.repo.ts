import { Response } from "express";
import Project from "../entity/project.entity";

export default class ProjectRepository {

    public async getEmployeeProjects(employeeId: number, res: Response) {
        Project.findAll({
            "where": {
                "employeeId": employeeId
            }
        })
            .then((result) => {
                res.send(result);
            }).catch((err) => { res.send(err); });
    }

    public async getAll(res: Response) {
        Project.findAll()
            .then((result) => {
                res.send(result);
            }).catch((err) => { res.send(err); });
    }

    public async addProject(data: any, res: Response) {
        Project.create(data).then((result) => {
            res.send(result);
        }).catch((err) => { res.send(err); });
    }

    public async deleteProject(id: number, res: Response) {
        Project.destroy({
            "where": {
                "id": id
            }
        }).then((result) => {
            res.send(result);
        }).catch((err) => { res.send(err); });
    }
}
