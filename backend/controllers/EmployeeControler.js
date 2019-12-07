import Controller from './controller';
import EmployeeInfoEntity from '../entity/EmployeeInfoEntity';
import EmployeeModule from '../models/EmployeeModule';

class EmployeeController {

    constructor() {
        this.controller = new Controller();
        this.employeeModel = new EmployeeModule();
    }

    findEmployeeAll(res) {
        this.employeeModel.findAll()
            .then(this.controller.findSuccess(res))
            .catch(this.controller.findError(res));
    }

    findEmployeeById(req, res) {
        const id = req.params.id;

        this.employeeModel.findInfoById(id)
            .then(this.controller.findSuccess(res))
            .catch(this.controller.findError(res));
    }

    createEmployee(req, res) {
        const employee = new EmployeeInfoEntity();
        // user.id = req.body.id;
        employee.name = req.body.name;
        employee.age = req.body.age;
        employee.quote = req.body.quote;
        employee.link = req.body.link;
        employee.position = req.body.position;

        this.employeeModel.createInfo(employee)
            .then(this.controller.createSuccess(res))
            .catch(this.controller.editError(res));
    }

    deleteEmployee(req, res) {
        const id = req.params.id;

        this.employeeModel.deleteInfo(id)
            .then(this.controller.editSuccess(res))
            .catch((error) => {
                if (error.errorCode === 21) {
                    return this.controller.deleteError(res)();
                }
                else {
                    return this.controller.editError(res)();
                }
            });
    }
}

export default EmployeeController;
