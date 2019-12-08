class EmployeeInfoEntity {
    /**
     * @param id ID
     * @param name string
     * @param age string
     * @param position string
     * @param quote string
     * @param link string
     */

    constructor(id, name, age, position, quote, link) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.quote = quote;
        this.position = position;
        this.link = link;
    }
}

export default EmployeeInfoEntity;
