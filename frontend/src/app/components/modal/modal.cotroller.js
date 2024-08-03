import { ModalModel } from "./modal.model";
import { ModalView } from "./modal.view";



export class TaskModalController {

    view = new ModalView()
    model = new ModalModel()

    constructor() {
        this.view.render()
    }
}