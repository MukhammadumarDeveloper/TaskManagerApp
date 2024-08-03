import { createTask, generateUniqueId, statusObj, getDate, getFormattedDate } from "../../../utils"
import { getStatus } from "../../../utils"
import { DashboardController } from "../dashboard/dashboard.controller"
import { TaskListController } from "../task-list/task-list.controller"
import "./modal.scss"

export class ModalView {
    selector = "task-modal"

    constructor() {
    }

    render(task, status, board) {
        const modal = document.createElement("div")
        modal.classList.add(this.selector)
        modal.innerHTML = `
            <div class="task-modal__container">
                <form class="modal-form">
                    <label class="label--title">
                        <input type="text" class="input__name" name="title" placeholder="Name the Task" required />
                    </label>
                    <label class="label label__status">
                        <span>Status</span>
                        <select name="status" required>
                            ${status ? `
                                <option value="${status}" class="option__${getStatus(status)}" selected disabled hidden><span>${statusObj[status]}</span</option>
                                ` : `
                                <option value="" selected disabled hidden>Empty</option>
                                `
                            }
                            <option value="DONE" class="option__done">
                                <span>Done</span>
                            </option>
                            <option value="IN_PROGRESS" class="option__inProgress"><span>In Progress</span></option>
                            <option value="REVIEW" class="option__review"><span>Review</span></option>
                            <option value="TODO" class="option__toDo"><span>To Do</span></option> 
                        </select>
                    </label>
                    <label class="label label__priority">
                        <span>Priority</span>
                        <select name="priority" required>
                            <option value="" selected disabled hidden>Empty</option>
                            <option value="LOW"><span>Low</span></option>
                            <option value="MEDIUM"><span>Medium</span></option>
                            <option value="TOP"><span>High</span></option>
                        </select>
                    </label>
                    <label class="label label__due-date">
                        <span>Due Date</span>
                        <input type="date" name="dueDate" placeholder="Empty" required/>
                    </label>
                    <label class="label label--creation-date">
                        <span>Creation Date</span>
                        <input type="date" name="creationDate" value="${getDate()}" required disabled/>
                    </label>
                    <label class="label label--description">
                        <span>Description</span>
                        <textarea name="content" placeholder="Please describe the Task" required></textarea>
                    </label>
                    <div class="task-modal--buttons">
                        ${ task ? `
                        <button class="delete-button">
                        <i class="fa-solid fa-trash"></i>
                        Delete
                        </button>
                        `: '' }
                        <button class="submit-button" type="submit">Save</button>
                    </div>
                </form>
                <button class="close-modal-button">
                    <i class="fa-solid fa-xmark"></i>
                </button>
            </div>
        `

        document.querySelector("body").appendChild(modal)

        document.querySelector(".close-modal-button").addEventListener("click", () => {
            document.querySelector("body").removeChild(modal)
        })

        document.querySelector(".modal-form").addEventListener("submit", async () => {
            event.preventDefault()
            const inputTitle = document.querySelector("[name='title']")
            const statusElement = document.querySelector("[name='status']")
            const priorityElement = document.querySelector("[name='priority']")
            const dueDateElement = document.querySelector("[name='dueDate']")
            const contentElement = document.querySelector("[name='content']")

            const taskData = {
                content: contentElement.value,
                dueDate: `${dueDateElement.value}${getFormattedDate()}`,
                priority: priorityElement.value,
                status: statusElement.value,
                title: inputTitle.value
            }

            console.log(taskData)

            await createTask(taskData)

            document.querySelector("body").removeChild(modal)

            if (board == "dashboard"){
                new DashboardController()
            } else if (board == "task-list") {
                new TaskListController()
            }
        })
    }
}