import ProjectEntity from '../entity/ProjectEntity';
import Controller from './controller';
import ProjectModule from "../models/ProjectModule";

class ProjectController {

    constructor() {
        this.controller = new Controller();
        this.projectModel = new ProjectModule();
    }

    findProjectAll(res) {
        this.projectModel.findAll()
            .then(this.controller.findSuccess(res))
            .catch(this.controller.findError(res));
    }


    findProjectByEmployeeId(req, res) {
        const id = req.params.id;

        this.projectModel.findProjectByEmployeeId(id)
            .then(this.controller.findSuccess(res))
            .catch(this.controller.findError(res));
    }

    findProjecById(req, res) {
        const id = req.params.id;

        this.projectModel.findProjecById(id)
            .then(this.controller.findSuccess(res))
            .catch(this.controller.findError(res));
    }

    createProject(req, res) {
        const project = new ProjectEntity();
        project.employee_id = req.body.employee_id;
        project.title = req.body.title;
        project.start_date = req.body.start_date;
        project.end_date = req.body.end_date;
        project.link = req.body.link;

        this.projectModel.createProject(employee)
            .then(this.controller.createSuccess(res))
            .catch(this.controller.editError(res));
    }

    deleteProject(req, res) {
        const id = req.params.id;

        this.projectModel.deleteProject(id)
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

export default ProjectController;
