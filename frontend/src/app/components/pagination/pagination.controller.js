import { PaginationModel } from "./pagination.model";
import { PaginationView } from "./pagination.view";


export class PaginationController {
    view = new PaginationView()
    model = new PaginationModel()

    constructor() {
        this.view.render()
    }
}