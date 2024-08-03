import { fetchTasks, formatDate, getPriority, getStatus, statusObj } from "../../../utils"
import plus from "../../../assets/imgs/plus.svg"
import "./dashboard.scss"
import { ModalView } from "../modal/modal.view"

const tasks = [
    {
        name: "Visual Design",
        desc: "Establish a disign system that includes color palettes",
        priority: "High",
        status: "Review",
    },
    {
        name: "Visual Design",
        desc: "Establish a disign system that includes color palettes",
        priority: "Medium",
        status: "IN_PROGRESS",
    },
]

export class DashboardView {
    selector = "main"

    constructor() {
        this.render()
    }

    render() {
        document.getElementById(this.selector).innerHTML = `
        <div class="container">
            <div class="table__wrapper">
                <table class="table">
                    <tr>
                        <th>Task</th>
                        <th>Describtion</th>
                        <th>Creation Date</th>
                        <th>Due Date</th>
                        <th>Priority</th>
                        <th>Status</th>
                    </tr>
                </table>
                <button type="button" class="add_card-btn">
                    <img src="${plus}" alt="plus" />
                    Add a card
                </button> 
            </div>
        </div>
        `
        
        this.renderItems()

        document.querySelector(".add_card-btn").addEventListener("click", () => {
            const modalView = new ModalView()
            modalView.render(null, null, "dashboard")
        })
    }

    async renderItems() {
        const data = await fetchTasks()
        const mainTable = document.querySelector(".table")
        data.forEach((task, index) => {
            const row = document.createElement("tr")

            const statusText = statusObj[task.status]
            console.log(statusText)
            row.innerHTML = `
                <td>${task.title}</td>
                <td>${task.content}</td>
                <td>${formatDate(task.createdDate)}</td>
                <td>${formatDate(task.dueDate)}</td>
                <td class="table__${getPriority(task.priority)}">
                    <span>${task.priority[0] + task.priority.slice(1).toLowerCase()}</span>
                </td>
                <td class="table__${task.status}">
                    <span>${statusText}</span>
                </td>
            `
            mainTable.appendChild(row)
        })
    }
}