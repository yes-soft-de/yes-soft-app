class SkillsEntity {
    /**
     * @param id ID
     * @param skill string
     * @param employee_id int
     */

     constructor (id, skill, employee_id) {
         this.id = id;
         this.skill = skill;
         this.employee_id = employee_id;
     }
}

export default SkillsEntity;