package miu.edu.sa.UserLoginClient;

import miu.edu.sa.UserLoginClient.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
public class ClientApp {

	private RestTemplate restTemplate = new RestTemplate();

	private String serverUrl = "http://localhost:8080";

	private String login(String username, String password) {
		String token;
		try {
			return restTemplate.postForObject(serverUrl + "/login", new LoginDto(username, password), String.class);
		} catch (Exception e) {
			throw new RuntimeException("Authentication failed");
		}
	}

	private <T> void sentPostRequest(String relativePath, T requestBody, String token) {
		String authorization = "Bearer " + token;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", authorization);

		HttpEntity<T> request = new HttpEntity<>(requestBody, headers);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForLocation(serverUrl + relativePath, request);
		System.out.println("Success...");
	}


	private <T> void sentDeleteRequest(String relativePath, String token) {
		String authorization = "Bearer " + token;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", authorization);

		HttpEntity<T> request = new HttpEntity<>(headers);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(serverUrl + relativePath, request);
		System.out.println("Success...");
	}

	private <T> void sentPutRequest(String relativePath, T requestBody, String token) {
		String authorization = "Bearer " + token;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", authorization);

		HttpEntity<T> request = new HttpEntity<>(requestBody, headers);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(serverUrl + relativePath, request);
		System.out.println("Success...");
	}

	private Element getElement(String relativePath, String token) {
		String authorization = "Bearer " + token;

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", authorization);

		HttpEntity<Object> request = new HttpEntity<>(headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Element> response = restTemplate.exchange(
				serverUrl + relativePath,
				HttpMethod.GET,
				request,
				Element.class
		);
		System.out.println("Success...");
		return response.getBody();
	}

	public void runLogin() {
		System.out.println("Testing login");

		String token;

		System.out.println("------- Logging in as Admin ---------");
		token = login("admin", "password");
		System.out.println("Success...");
		System.out.println("------- Logged in as Admin ---------");


		ElementDTO element = new ElementDTO("123", "premium", 140.0, "First Class");
		ElementDTO element1 = new ElementDTO("124", "post-premium", 130.0, "Second Class");


		System.out.println("------- Adding element -------");

		sentPostRequest("/element", element, token);
		sentPostRequest("/element", element1, token);

		System.out.println("-------- Getting created Element ----------");

		Element element2 = getElement("/element/123", token);
		System.out.println(element2);


		System.out.println("****** Updating Element*****");

		try {
			element1.setType("XL");
			sentPutRequest("/element/124", element1, token);
		} catch (Exception ex) {
			System.out.println("element not found");
		}
		System.out.println("***** Deleting Element by ID******");
		try {
			sentDeleteRequest("/element/124", token);
		} catch (Exception e) {
			System.out.println("element not found");

		}
	}
}

