<?php
App::uses('Controller', 'Controller');

class TracksController extends Controller {
//	public $components = array('RequestHandler');
		
	public function record($id = null) {
		if (!$id) {
			throw new NotFoundException(__('Invalid post'));
		}
		$track = $this->Track->findById($id)['Track'];
		if (!$track) {
			throw new NotFoundException(__('Invalid post'));
		}
		$this->viewClass = 'Json';
		$result = json_decode($track['actions'], true);
		$this->set(compact('result'));
		$this->set('_serialize', 'result');
	}
	
	public function insert() {
		if ($this->request->is('post')) {
			$this->Track->create();
			$this->Track['actions'] = $this->request->data;
			$actions = json_decode($this->Track['actions'], true);
			$this->Track['start_datetime'] = $actions['date'];
			$this->Track['name'] = $actions['name'];
			$this->Track['os'] = $actions['os'];
			$this->Track['device'] = $actions['device'];
			$this->Track['os'] = $actions['os'];

			$this->Track->save();
			
			$result = ['status' => 'complete', 'msg' => 'Request completed.'];
			$this->viewClass = 'Json';
			$this->set(compact('result'));
			$this->set('_serialize', 'result');
		}
	}
}
