"use strict";
var displayEl = document.getElementById("display");
var primaryBtnEl = document.getElementById("primaryBtn");
var resetBtnEl = document.getElementById("resetBtn");
var toastEl = document.getElementById("toast");
var toastTextEl = document.getElementById("toastText");
var scoreBadgeEl = document.getElementById("scoreBadge");
var startTimeMs = null;
var rafId = null;
var running = false;
// Load & persist balance
var totalPoints = Number(localStorage.getItem("one_sec_total_points") || "0");
var updateScoreUI = function () {
    scoreBadgeEl.textContent = "".concat(totalPoints, " pts");
    if (totalPoints >= 1000) {
        window.location.href = "./win_screen.html";
    }
};
updateScoreUI();
var now = function () { return performance.now(); };
var formatSeconds = function (sec) { return sec.toFixed(2); };
function vibrate(pattern) {
    var _a;
    try {
        (_a = navigator.vibrate) === null || _a === void 0 ? void 0 : _a.call(navigator, pattern);
    }
    catch (_b) { }
}
function showToast(text) {
    toastTextEl.textContent = text;
    toastEl.style.opacity = "1";
    setTimeout(function () {
        toastEl.style.opacity = "0";
    }, 1500);
}
function loop() {
    if (!running || startTimeMs === null)
        return;
    var elapsed = (now() - startTimeMs) / 1000;
    displayEl.textContent = formatSeconds(elapsed);
    rafId = requestAnimationFrame(loop);
}
function start_timer() {
    if (running)
        return;
    running = true;
    displayEl.classList.remove("text-green-400", "text-yellow-300", "text-red-500");
    startTimeMs = now();
    primaryBtnEl.textContent = "Stop";
    primaryBtnEl.classList.replace("bg-emerald-500", "bg-rose-500");
    primaryBtnEl.classList.replace("hover:bg-emerald-400", "hover:bg-rose-400");
    primaryBtnEl.classList.replace("text-emerald-950", "text-rose-950");
    resetBtnEl.classList.add("hidden");
    if (rafId)
        cancelAnimationFrame(rafId);
    rafId = requestAnimationFrame(loop);
    vibrate(10);
}
function stop_timer() {
    if (!running || startTimeMs === null)
        return;
    running = false;
    if (rafId)
        cancelAnimationFrame(rafId);
    var elapsed = (now() - startTimeMs) / 1000;
    var rounded = Math.round(elapsed * 100) / 100; // centisecond precision
    displayEl.textContent = formatSeconds(rounded);
    displayEl.classList.remove("text-green-400", "text-yellow-300", "text-red-500");
    // Round-based score
    var points = 0;
    if (rounded === 1.0) {
        points = 420;
        displayEl.classList.add("text-green-400");
    }
    else if ((elapsed >= 0.9 && elapsed <= 0.95) ||
        (elapsed >= 1.05 && elapsed <= 1.1)) {
        points = 31;
        displayEl.classList.add("text-yellow-300");
    }
    else {
        displayEl.classList.add("text-red-500");
    }
    // Accumulate & persist
    totalPoints += points;
    localStorage.setItem("one_sec_total_points", String(totalPoints));
    updateScoreUI();
    if (points === 420) {
        showToast("Perfect! +420 pts");
        vibrate([0, 25, 50, 25]);
    }
    else if (points === 31) {
        showToast("+31 pts — so close");
        vibrate(20);
    }
    else {
        showToast("0 pts — try again");
    }
    // Reset UI to Start mode
    primaryBtnEl.textContent = "Start";
    primaryBtnEl.classList.replace("bg-rose-500", "bg-emerald-500");
    primaryBtnEl.classList.replace("hover:bg-rose-400", "hover:bg-emerald-400");
    primaryBtnEl.classList.replace("text-rose-950", "text-emerald-950");
    resetBtnEl.classList.remove("hidden");
}
function reset() {
    running = false;
    if (rafId)
        cancelAnimationFrame(rafId);
    startTimeMs = null;
    displayEl.textContent = "0.00";
    primaryBtnEl.textContent = "Start";
    resetBtnEl.classList.add("hidden");
}
primaryBtnEl.addEventListener("click", function () {
    return running ? stop_timer() : start_timer();
});
resetBtnEl.addEventListener("click", reset);
displayEl.parentElement.addEventListener("click", function () {
    return running ? stop_timer() : start_timer();
});
window.addEventListener("keydown", function (e) {
    if (e.code === "Space") {
        e.preventDefault();
        running ? stop_timer() : start_timer();
    }
});
