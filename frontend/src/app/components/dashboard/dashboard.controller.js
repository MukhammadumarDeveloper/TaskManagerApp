import { DashboardModel } from "./dashboard.model";
import { DashboardView } from "./dashboard.view";

export class DashboardController {
    view = new DashboardView()
    model = new DashboardModel()

    constructor() {

    }
}