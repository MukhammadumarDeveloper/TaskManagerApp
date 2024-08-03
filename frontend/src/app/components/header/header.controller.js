import { HeaderModel } from "./header.model"
import { HeaderView } from "./header.view"

export class HeaderController {
    view = new HeaderView()
    model = new HeaderModel()

    constructor() {
    }
}