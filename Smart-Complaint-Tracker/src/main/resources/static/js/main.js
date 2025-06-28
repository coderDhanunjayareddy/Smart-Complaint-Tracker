// main.js
document.addEventListener('DOMContentLoaded', () => {
  console.log('Frontend loaded');
});

function upvote(complaintId) {
  fetch(`/complaint/${complaintId}/upvote`, {
    method: 'POST'
  })
  .then(res => {
    if (!res.ok) throw new Error("Upvote request failed");
    return res.json();  // parse as JSON (the int upvote count)
  })
  .then(newCount => {
    const voteSpan = document.getElementById(`vote-${complaintId}`);
    if (voteSpan) {
      voteSpan.textContent = newCount;  // update with server count
    }
  })
  .catch(err => console.error("Upvote failed", err));
}