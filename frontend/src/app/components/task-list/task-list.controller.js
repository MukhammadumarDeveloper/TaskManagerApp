import { TaskListModel } from "./task-list.model";
import { TaskListView } from "./task-list.view";


export class TaskListController {

    view = new TaskListView()
    model = new TaskListModel()

    constructor() {

    }
}