import { Column, CreatedAt, HasMany, Model, Table, UpdatedAt } from "sequelize-typescript";

@Table
export default class Project extends Model<Project> {
    @Column
    public title: string;

    @Column
    public startDate: string;

    @Column
    public endDate: string;

    @Column
    public link: string;

    @Column
    public employeeId: string;

    @CreatedAt
    @Column
    public createdAt!: Date;

    @UpdatedAt
    @Column
    public updatedAt!: Date;
}
