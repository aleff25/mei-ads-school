package pt.iscte.mei.school.classrooms.model;

public enum Caracteristics implements CaracteriscticsAction {

    CLASSROOM_MASTER {
        @Override
        public boolean performAction() {
            return false;
        }
    },
    CLASSROOM_NORMAL {
        @Override
        public boolean performAction() {
            return false;
        }
    },

}
