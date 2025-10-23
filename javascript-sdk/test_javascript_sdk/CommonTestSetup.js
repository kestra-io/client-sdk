import KestraClient from "../src/KestraClient";

export const host = "http://localhost:9903"
export const username = "root@root.com"
export const password = "Root!1234"
export const MAIN_TENANT = "main";

export function kestraClient() {
    return new KestraClient(host, null, username, password);
}
export function randomId() {
    return Math.random().toString(36).substring(2, 10);
}

export function randomEmail() {
    return randomId() + '@example.com';
}
