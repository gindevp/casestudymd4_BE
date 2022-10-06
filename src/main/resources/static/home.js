


function getPosts(posts){

    return `<div class="status-field-container write-post-container">`+
        `<div class="user-profile-box">`+
            `<div class="user-profile">`+
                `<img src="/images/profile-pic.png" alt="">`+
                    `<div>`+
                        `<p id="users_name">${posts.appUsers.userName}</p>`+
                       ` <small>${posts.postTime}</small>`+
                   ` </div>`+
           ` </div>`+
          `  <div>`+
               ` <a href="#"><i class="fas fa-ellipsis-v"></i></a>`+
          `  </div>`+
        `</div>`+
        `<div class="status-field">`+
            `<p>${posts.content} <a href="#">#This_Post_is_Better!!!!</a></p>`+
           ` <img src="/images/feed-image-1.png" alt="">`+
       ` </div>`+
       ` <div class="post-reaction">`+
           ` <div class="activity-icons">`+
               ` <div><img src="/images/like-blue.png" alt="">120</div>`+
                `<div onclick="listComments(${posts.id})"><img src="/images/comments.png" alt="">52</div>`+
               ` <div><img src="/images/share.png" alt="">35</div>`+
            `</div>`+
           ` <div class="post-profile-picture">`+
               ` <img src="/images/profile-pic.png " alt=""> <i class=" fas fa-caret-down"></i>`+
           ` </div>`+
       ` </div>`+
       ` <div class="status-comment">`+
            `<div class="comment-user">`+
               ` <img src="/images/profile-pic.png" alt="" class="comment-user__avt">`+
            `</div>`+
            `<input type="text" placeholder="Viết bình luận" id="status-comment">`+
        `</div>`+
        `<div class="status-comment-list" id="cmt+${posts.id}">`+
           // ` <div class="comment-user">`+
           //      `<img src="/images/profile-pic.png" alt="" class="comment-user__avt">`+
           //          `<div class="comment-user-ct">`+
           //             ` <span class="comment-user__name">Hiennguyen</span>`+
           //              `<span class="comment-user-content">helloooooooooooooooooooooooo</span>`+
           //         ` </div>`+
           // ` </div>`+
       ` </div>`+
   ` </div>`;
}


function listPosts(){
    $.ajax({
        type:"GET",
        url:"/posts",
        success:function (data){
            let ct= '<div class="story-gallery">'+
                '<div class="story story1">'+
                  '  <img src="/images/upload.png" alt="">'+
                       ' <p>Post Story</p>'+
               ' </div>'+
               ' <div class="story story2">'+
                   ' <img src="/images/member-1.png" alt="">'+
                       ' <p>Alison</p>'+
                '</div>'+
               ' <div class="story story3">'+
                   ' <img src="/images/member-2.png" alt="">'+
                      '  <p>Jackson</p>'+
              '  </div>'+
               ' <div class="story story4">'+
                   ' <img src="/images/member-3.png" alt="">'+
                     '   <p>Samona</p>'+
               ' </div>'+
              '  <div class="story story5">'+
                 '   <img src="/images/member-4.png" alt="">'+
                       ' <p>John</p>'+
             '   </div>'+
           ' </div>'+
            '<div class="write-post-container">'+
               ' <div class="user-profile">'+
                   ' <img src="/images/profile-pic.png" alt="">'+
                       ' <div>'+
                           ' <p> Alex Carry</p>'+
                         '   <small>Public <i class="fas fa-caret-down"></i></small>'+
                        '</div>'+
                '</div>'+
              '  <div class="post-upload-textarea">'+
                    '<textarea name="" placeholder="What is on your mind, Alex?"  cols="30" rows="3"></textarea>'+
                   '<div class="add-post-links">'+
                        '<a href="#"><img src="/images/live-video.png" alt="">Live Video</a>'+
                       ' <a href="#"><img src="/images/photo.png" alt="">Photo/Video</a>'+
                        '<a href="#"><img src="/images/feeling.png" alt="">Feeling Activity</a>'+
                   '</div>'+
               '</div>'+
            '</div>';
            console.log(data);

            for(let i=0; i<data.content.length; i++){
                ct += getPosts(data.content[i]);
            }

            document.getElementById('posts').innerHTML = ct;
        }
    })
}

listPosts();

function listComments(id){

    console.log(id)
    $.ajax({
        type: "GET",
        url: "/api/comments/post/"+id,
        success:function (data){
            console.log("hello cmt")
            console.log(data)
            let ct = ""
            for(let i=0; i<data.length; i++){
                ct +=`<div class="">`+
                    ` <div class="comment-user">`+
                    `<img src="/images/profile-pic.png" alt="" class="comment-user__avt">`+
                    `<div class="comment-user-ct">`+
                    ` <span class="comment-user__name">${data[i].appUsers.userName}</span>`+
                    `<span class="comment-user-content">${data[i].cmtContent}</span>`+
                    ` </div>`+
                    ` </div>`+
                    ` </div>`
            }

            document.getElementById(`cmt+${id}`).innerHTML= ct;
        }
    })
}

