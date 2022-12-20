
Kakao.init('76496f4d57a44e3ae691f6237f8ca6d3');

function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (res) {
			const form = document.createElement('form');
			form.setAttribute('method', 'post');
			form.setAttribute('action', '/kakao_login');
			
			const datas = [
				{ name: 'id', value: res.id },
				{ name: 'emailAddress', value: res.kakao_account.email },
				{ name: 'gender', value: res.kakao_account.gender == 'female' ? 1 : 2 },
			];
			
			for(let data of datas) {
				const input = document.createElement('input');
				input.setAttribute('type', 'hidden');
				input.setAttribute('name', data.name);
				input.setAttribute('value', data.value);
				form.appendChild(input);
			}
			document.body.appendChild(form);
			form.submit();
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
}
 
function kakaoLogout() {
	if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
}  