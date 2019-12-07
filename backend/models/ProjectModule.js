import Model from './Module';
import ProjectEntity from '../entity/ProjectEntity';

class ProjectModule {

    constructor() {
        this.model = new Model();
    }

    findAll() {
        const sql = `SELECT * FROM projects`;

        return this.model.findAll(sql)
            .then((resultList) => {
                const projectsInfo = [];

                for (const result of resultList) {
                    projectsInfo.push(new ProjectEntity(result.id, result.employee_id, result.start_date, result.end_date, result.title, result.link));
                }

                return projectsInfo;
            });
    }

    findProjectByEmployeeId(id) {
        const sql = `SELECT * FROM projects WHERE employee_id = $id`;
        const params = {
            $id: id
        };

        return this.model.findAll(sql, params)
            .then((resultList) => {
                const list = [];
                for (const result of resultList) {
                    list.push(new ProjectEntity(result.id, result.employee_id, result.start_date, result.end_date, result.title, result.link));
                }
                return list;
            });
    }

    createProject(project) {
        const params = {
            $e_id: project.employee_id,
            $start_date: project.start_date,
            $end_date: project.end_date,
            $title: project.title,
            $link: project.link
        };
        const sql = `INSERT INTO projects (employee_id , start_date, end_date, title, link) 
            VALUES ("${project.employee_id}", "${project.$start_date}", "${project.end_date}",
                        "${project.title}", "${project.link}");`;

        return this.model.run(sql, params)
            .then((id) => {
                return this.model.findOne(id);
            });
    }

    deleteProject(id) {
        const sql = `DELETE FROM projects WHERE id = $id`;

        const params = {
            $id: id
        };

        return this.model.run(sql, params);
    }

}

export default ProjectModule;
