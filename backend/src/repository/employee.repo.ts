import { Request, Response } from "express";
import "reflect-metadata";
import EmployeeInfoEntity from "../entity/employee_info.entity";

export default class EmployeeRepository {

    public async getAll(res: Response) {
        EmployeeInfoEntity.findAll()
        .then((result) => {
            res.send(result);
        }).catch((err) => { res.send(err); });
    }

    public async getById(id: number, res: Response) {
        console.log(`Requesting with Id: ${id}`);
        EmployeeInfoEntity.findByPk(id)
            .then((result) => {
                res.send(result);
            }).catch((err) => { res.send(err); });
    }

    public async insert(req: Request, res: Response) {
        EmployeeInfoEntity.create(req.body)
            .then((result) => {
                res.send(result);
            }).catch((err) => { res.send(err); });
    }
}
