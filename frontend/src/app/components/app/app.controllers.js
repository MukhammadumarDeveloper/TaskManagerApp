import { HeaderController } from "../header/header.controller";
import { TaskModalController } from "../modal/modal.cotroller";
import { PaginationController } from "../pagination/pagination.controller";
import { AppModel } from "./app.model";
import { AppView } from "./app.view";


export class AppControllers {
    view = new AppView()
    model = new AppModel()
    header = new HeaderController()
    pagination = new PaginationController()

    constructor() {
    }
}