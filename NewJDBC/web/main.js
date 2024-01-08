/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
  const overlay = document.getElementById('overlay');
    const loginLink = document.getElementById('loginLink');
    const loginForm = document.getElementById('loginForm');
     const b = document.querySelector('.loginForm form');
     const a = document.getElementById('link');
        document.addEventListener('DOMContentLoaded', (event) => {
    const deleteLinks = document.querySelectorAll('.deleteLink');
    deleteLinks.forEach(link => {
        link.addEventListener('click', () => {
            // Thực hiện logic cập nhật của bạn ở đây
            gsap.to(overlay, { display: 'block', opacity: 1, duration: 0.3 });
            gsap.to(loginForm, { display: 'block',transform: 'translate(-50%, -50%) translateY(0)', opacity: 1, duration: 0.3 });
            b.style.display='block';
        });
    });
});
    document.addEventListener('DOMContentLoaded', (event) => {
   const updateLinks = document.querySelectorAll('.updateLink');
    updateLinks.forEach(link => {
        link.addEventListener('click', () => {
            // Thực hiện logic cập nhật của bạn ở đây
            gsap.to(overlay, { display: 'block', opacity: 1, duration: 0.3 });
            gsap.to(loginForm, { display: 'block',transform: 'translate(-50%, -50%) translateY(0)', opacity: 1, duration: 0.3 });
             b.style.display='block';
        });
    });
});

    a.addEventListener('click',() =>{
         gsap.to(overlay, { display: 'block', opacity: 1, duration: 0.3 });
        gsap.to(loginForm, { transform: 'translate(-50%, -50%) translateY(0)', opacity: 1, duration: 0.3 });
         b.style.display='block';
    });

    loginLink.addEventListener('click', () => {
        gsap.to(overlay, { display: 'block', opacity: 1, duration: 0.3 });
        gsap.to(loginForm, { transform: 'translate(-50%, -50%) translateY(0)', opacity: 1, duration: 0.3 });
         b.style.display='block';
    });

    overlay.addEventListener('click', () => {
        gsap.to(overlay, { display: 'none',opacity: 0, duration: 0.3 });
        gsap.to(loginForm, { transform: 'translate(-50%, -50%) translateY(-100%)', opacity: 0, duration: 0.3, delay: 0.3 });
        
    });
