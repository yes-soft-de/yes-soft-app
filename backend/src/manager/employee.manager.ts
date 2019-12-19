import {Request, Response} from "express";
import EmployeeInfoEntity from "../entity/employee_info.entity";
import EmployeeRepository from "../repository/employee.repo";

export default class EmployeeManager {
    private employeeRepo: EmployeeRepository;
    constructor() {
        this.employeeRepo = new EmployeeRepository();
    }

    public getAll(res: Response) {
        this.employeeRepo.getAll(res);
    }

    public getById(req: Request, res: Response) {
        this.employeeRepo.getById(+req.params.id, res);
    }

    public insert(req: Request, res: Response) {
        this.employeeRepo.insert(req, res);
    }
}
